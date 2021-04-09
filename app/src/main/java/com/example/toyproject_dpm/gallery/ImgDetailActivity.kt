package com.example.toyproject_dpm.gallery


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.toyproject_dpm.databinding.ActivityImgDetailBinding

class ImgDetailActivity : AppCompatActivity() {
    private lateinit var mbinding: ActivityImgDetailBinding
    private var image: String? = null
    private var author: String? = null
    private var width: String? = null
    private var height: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityImgDetailBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        image = intent.getStringExtra(IMAGE)
        author = intent.getStringExtra(AUTHOR)
        width = intent.getStringExtra(WIDTH)
        height = intent.getStringExtra(HEIGHT)

        val AUTHOR = "Author : ${author}"
        val SIZE = "Size : ${width} x ${height}"

        mbinding.txtAuthor.text = AUTHOR
        mbinding.txtSize.text = SIZE

        Glide.with(this).load(image).into(mbinding.detailImg)
    }

    private val IMAGE = "image"
    private val AUTHOR = "author"
    private val WIDTH = "width"
    private val HEIGHT = "height"

}