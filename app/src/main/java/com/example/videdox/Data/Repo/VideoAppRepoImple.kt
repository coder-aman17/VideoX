package com.example.videdox.Data.Repo

import android.app.Application
import android.provider.MediaStore
import com.example.videdox.Data.VideoFile
import com.example.videdox.Domain.Repo.VideoAppRepo
import kotlinx.coroutines.flow.Flow

class VideoAppRepoImple : VideoAppRepo {
    fun getAllVideos(application: Application): ArrayList<VideoFile> {
        val allVideo = ArrayList<VideoFile>()
        val projection = arrayOf(
            MediaStore.Video.Media._ID,
            MediaStore.Video.Media.DATA,
            MediaStore.Video.Media.TITLE,
            MediaStore.Video.Media.SIZE,
            MediaStore.Video.Media.DATE_ADDED,
            MediaStore.Video.Media.DURATION,
            MediaStore.Video.Media.DISPLAY_NAME,
        )
        val uri= MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        val memoryCursor = application.contentResolver.query(uri,projection,null,null,null  )
        if (memoryCursor != null) {
            while(memoryCursor.moveToNext()){
                val id = memoryCursor.getString(0)
                val path = memoryCursor.getString(1)
                val title = memoryCursor.getString(2)
                val size = memoryCursor.getString(3)
                val dateAdded = memoryCursor.getString(4)
                val duration = memoryCursor.getString(5)
                val filename = memoryCursor.getString(6)
                val videoFile = VideoFile(id= id,path = path,title= title,fileName=filename,size = size,duration= duration,dateAdded = dateAdded)
                allVideo.add(videoFile)

                if(memoryCursor.isLast) {
                    break
                }



            }
            memoryCursor.close()
        }
        return allVideo
    }

    }
