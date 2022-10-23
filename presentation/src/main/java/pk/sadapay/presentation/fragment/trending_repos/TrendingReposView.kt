package pk.sadapay.presentation.fragment.trending_repos

interface TrendingReposView {
    fun configureSwipeRefreshLayout()
    fun addRecyclerViewDivider()
    fun disableRecyclerViewChangeAnimations()
    fun setupListAdapter()

    fun showShimmerAnimation()
    fun stopShimmerAnimation()

    fun showRefreshingAnimation()
    fun stopRefreshingAnimation()
}