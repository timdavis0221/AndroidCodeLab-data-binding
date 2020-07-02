/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.databinding.basicsample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.android.databinding.basicsample.R
import com.example.android.databinding.basicsample.data.SimpleViewModel
import com.example.android.databinding.basicsample.databinding.PlainActivityBinding

/**
 * Plain old activity with lots of problems to fix.
 */
class PlainOldActivity : AppCompatActivity() {

    // Obtain ViewModel from ViewModelProviders
    private val simpleViewModel by lazy {
        ViewModelProviders.of(this).get(SimpleViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.plain_activity)
        val binding : PlainActivityBinding = // Binding classes are generated automatically by the library.
                DataBindingUtil.setContentView(this, R.layout.plain_activity)

        // TODO: Explicitly setting initial values is a bad pattern. We'll fix that.
//        updateName()
//        binding.name = "Tim"
//        binding.lastName = "Davis"
        binding.simpleViewModel = simpleViewModel

        // LiveData is a lifecycle-aware observable
        // so you need to specify what lifecycle owner to use.
        binding.lifecycleOwner = this

//        updateLikes()
    }

    /**
     * This method is triggered by the `android:onclick` attribute in the layout. It puts business
     * logic in the activity, which is not ideal. We should do something about that.
     */
//    fun onLike(view: View) {
//        simpleViewModel.onLike()
//        updateLikes()
//    }

    /**
     * So much findViewById! We'll fix that with Data Binding.
     */
//    private fun updateName() {
//        findViewById<TextView>(R.id.plain_name).text = viewModel.name
//        findViewById<TextView>(R.id.plain_lastname).text = viewModel.lastName
//    }

    /**
     * This method has many problems:
     * - It's calling findViewById multiple times
     * - It has untestable logic
     * - It's updating two views when called even if they're not changing
     */
//    private fun updateLikes() {
//        findViewById<TextView>(R.id.likes).text = simpleViewModel.likes.toString()
//        findViewById<ProgressBar>(R.id.progressBar).progress =
//            (simpleViewModel.likes * 100 / 5).coerceAtMost(100)
//        val image = findViewById<ImageView>(R.id.imageView)
//
//        val color = getAssociatedColor(simpleViewModel.popularity, this)
//
//        ImageViewCompat.setImageTintList(image, ColorStateList.valueOf(color))
//
//        image.setImageDrawable(getDrawablePopularity(simpleViewModel.popularity, this))
//    }

//    private fun getAssociatedColor(popularity: Popularity, context: Context): Int {
//        return when (popularity) {
//            Popularity.NORMAL -> context.theme.obtainStyledAttributes(
//                intArrayOf(android.R.attr.colorForeground)
//            ).getColor(0, 0x000000)
//            Popularity.POPULAR -> ContextCompat.getColor(context, R.color.popular)
//            Popularity.STAR -> ContextCompat.getColor(context, R.color.star)
//        }
//    }

//    private fun getDrawablePopularity(popularity: Popularity, context: Context): Drawable? {
//        return when (popularity) {
//            Popularity.NORMAL -> {
//                ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp)
//            }
//            Popularity.POPULAR -> {
//                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
//            }
//            Popularity.STAR -> {
//                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
//            }
//        }
//    }
}
