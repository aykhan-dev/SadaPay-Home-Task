package pk.sadapay.presentation.fragment.trending_repos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pk.sadapay.domain.ui_model.RepoUIModel
import pk.sadapay.presentation.databinding.ItemTrendingRepoBinding

class TrendingRepoViewHolder private constructor(
    private val binding: ItemTrendingRepoBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(
        model: RepoUIModel,
        onItemExpand: (position: Int) -> Unit,
    ): Unit = with(binding) {
        model.ownerAvatarUrl?.let { url ->
            Glide.with(ivProfile)
                .load(url)
                .circleCrop()
                .into(ivProfile)
        }

        tvProfileName.text = model.ownerName
        tvRepoName.text = model.name

        tvRepoDescription.text = model.description

        tvLanguage.isVisible = !model.language.isNullOrEmpty()
        tvLanguage.text = model.language.orEmpty()

        tvStar.text = model.starCount.toString()

        groupDetails.isVisible = model.isExpanded

        root.setOnClickListener { onItemExpand(adapterPosition) }
    }

    companion object {
        fun create(parent: ViewGroup): TrendingRepoViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemTrendingRepoBinding.inflate(inflater, parent, false)
            return TrendingRepoViewHolder(binding)
        }
    }

}