package com.example.wfiappkotlin.data

import android.app.Activity
import com.example.wfiappkotlin.R

object DataProvider {

    val institutes: ArrayList<Institute> = ArrayList()

    fun getInstituteData(activity: Activity){
        val instituteList = activity.resources.getStringArray(R.array.institute_titles)
        val instituteInfo = activity.resources.getStringArray(R.array.institute_info)
        val instituteImageResources = activity.resources.obtainTypedArray(R.array.institute_images)

        instituteList.indices.forEach { i ->
            institutes.add(Institute(
                instituteList[i],
                instituteInfo[i],
                instituteImageResources.getResourceId(i, 0)))
        }

        instituteImageResources.recycle()
    }
}