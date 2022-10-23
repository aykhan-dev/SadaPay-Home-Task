package pk.sadapay.presentation.fragment.trending_repos

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import pk.sadapay.domain.ui_model.RepoUIModel

private val uiModelDiffer
    get() = object : DiffUtil.ItemCallback<RepoUIModel>() {

        override fun areItemsTheSame(oldItem: RepoUIModel, newItem: RepoUIModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: RepoUIModel, newItem: RepoUIModel): Boolean {
            return oldItem.id == newItem.id
        }

    }

class TrendingReposListAdapter : ListAdapter<RepoUIModel, TrendingRepoViewHolder>(uiModelDiffer) {

    private var prevClickedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingRepoViewHolder {
        return TrendingRepoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: TrendingRepoViewHolder, position: Int) {
        holder.onBind(
            model = getItem(position),
            onItemExpand = ::onItemExpand,
        )
    }

    private fun onItemExpand(clickedPosition: Int) {
        if (clickedPosition == prevClickedPosition) {
            val alreadyClickedModel = getItem(prevClickedPosition)
            alreadyClickedModel.isExpanded = !alreadyClickedModel.isExpanded
            notifyItemChanged(prevClickedPosition)
            return
        }

        if (prevClickedPosition >= 0) {
            val prevClickedModel = getItem(prevClickedPosition)
            prevClickedModel.isExpanded = false
            notifyItemChanged(prevClickedPosition, Unit)
        }

        val clickedModel = getItem(clickedPosition)
        clickedModel.isExpanded = true
        notifyItemChanged(clickedPosition, Unit)

        prevClickedPosition = clickedPosition
    }
}
