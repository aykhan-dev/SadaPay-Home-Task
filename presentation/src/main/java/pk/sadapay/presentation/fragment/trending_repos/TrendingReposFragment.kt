package pk.sadapay.presentation.fragment.trending_repos

import android.view.LayoutInflater
import android.view.ViewGroup
import pk.sadapay.presentation.base.BaseFragment
import pk.sadapay.presentation.databinding.FragmentTrendingReposBinding
import kotlin.reflect.KClass

class TrendingReposFragment :
    BaseFragment<Unit, Unit, Unit, FragmentTrendingReposBinding, TrendingReposViewModel>() {

    override val screenName: String
        get() = "trending_repos_screen"

    override val vmClazz: KClass<TrendingReposViewModel>
        get() = TrendingReposViewModel::class

    override val bindingCallback: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTrendingReposBinding
        get() = FragmentTrendingReposBinding::inflate

    override val onBind: FragmentTrendingReposBinding.() -> Unit = {
        root.displayedChild = 0
    }

}