package pk.sadapay.presentation.fragment.trending_repos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.SimpleItemAnimator
import pk.sadapay.presentation.base.BaseFragment
import pk.sadapay.presentation.databinding.FragmentTrendingReposBinding
import kotlin.reflect.KClass


class TrendingReposFragment :
    BaseFragment<TrendingReposState, Unit, TrendingReposEvent, FragmentTrendingReposBinding, TrendingReposViewModel>(),
    TrendingReposView {

    override val screenName: String
        get() = "trending_repos_screen"

    override val vmClazz: KClass<TrendingReposViewModel>
        get() = TrendingReposViewModel::class

    override val bindingCallback: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTrendingReposBinding
        get() = FragmentTrendingReposBinding::inflate

    private val trendingReposListAdapter by lazy { TrendingReposListAdapter() }

    override val onBind: FragmentTrendingReposBinding.() -> Unit = {
        configureSwipeRefreshLayout()
        addRecyclerViewDivider()
        disableRecyclerViewChangeAnimations()
        setupListAdapter()
    }

    override fun onStateChanged(state: TrendingReposState) {
        if (state.isLoading) showShimmerAnimation() else stopShimmerAnimation()
        if (state.isRefreshing) showRefreshingAnimation() else stopRefreshingAnimation()
        trendingReposListAdapter.submitList(state.repos)
    }

    override fun configureSwipeRefreshLayout() {
        binding.layoutTrendingRepos.apply {
            swipeRefreshLayout.setOnRefreshListener { onEvent(TrendingReposEvent.Refresh) }
        }
    }

    override fun addRecyclerViewDivider() {
        binding.layoutTrendingRepos.apply {
            context?.let {
                val dividerDrawable = ContextCompat.getDrawable(
                    it,
                    pk.sadapay.presentation.R.drawable.divider_trending_repos
                )

                dividerDrawable?.let { drawable ->
                    val itemDecorator = DividerItemDecoration(it, DividerItemDecoration.VERTICAL)
                    itemDecorator.setDrawable(drawable)

                    rvGithubRepos.addItemDecoration(itemDecorator)
                }
            }
        }
    }

    override fun disableRecyclerViewChangeAnimations() {
        binding.layoutTrendingRepos.apply {
            (rvGithubRepos.itemAnimator as? SimpleItemAnimator)?.apply {
                supportsChangeAnimations = false
                changeDuration = 0L
            }
        }
    }

    override fun setupListAdapter() {
        binding.layoutTrendingRepos.apply {
            rvGithubRepos.adapter = trendingReposListAdapter
        }
    }

    override fun showShimmerAnimation() {
        binding.root.displayedChild = 0
        binding.layoutShimmer.root.startShimmerAnimation()
    }

    override fun stopShimmerAnimation() {
        binding.root.displayedChild = 1
        binding.layoutShimmer.root.stopShimmerAnimation()
    }

    override fun showRefreshingAnimation() {
        binding.layoutTrendingRepos.swipeRefreshLayout.isRefreshing = true
    }

    override fun stopRefreshingAnimation() {
        binding.layoutTrendingRepos.swipeRefreshLayout.isRefreshing = false
    }

}