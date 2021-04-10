package com.example.toyproject_dpm.gallery

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.toyproject_dpm.databinding.FragmentGalleryBinding
import com.example.toyproject_dpm.model.ImageList
import com.example.toyproject_dpm.retrofit.APIClient
import com.example.toyproject_dpm.retrofit.APIService
import kotlinx.android.synthetic.main.fragment_gallery.*
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.toyproject_dpm.model.ImageModel as ImageModel

class GalleryFragment : Fragment() {
    private lateinit var mbinding: FragmentGalleryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mbinding = FragmentGalleryBinding.inflate(inflater, container, false)

        getImageByRetrofit()
        return mbinding.root
    }
    fun responseSuccess(response: ImageList?) {
        val images: ArrayList<ImageModel> = arrayListOf()
        if (response != null) {
            try {
                Log.e(TAG, response.toString())
                for (image in response) {
                    images.add(image)
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
        val imageAdapter = ImageAdapter()
        imageAdapter.ImageData = images
        mbinding.Gridrcv.adapter = imageAdapter
        mbinding.Gridrcv.layoutManager = GridLayoutManager(this.context, 4)
    }

    private fun getImageByRetrofit() {
        val apiClient: APIService = APIClient().getUserService()
        val stringCall: Call<ImageList> = apiClient.getRequest()
        stringCall.enqueue(object : Callback<ImageList> {
            override fun onFailure(call: Call<ImageList>, t: Throwable) {
                Log.e("failure", t.localizedMessage)
            }

            override fun onResponse(call: Call<ImageList>, response: Response<ImageList>) {
                Log.d(TAG, "response : ${response.body()!!}")
                responseSuccess(response.body())
            }
        })
    }


}


