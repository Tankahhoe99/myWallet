package com.example.mywallet

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface InOutLogDao {
    //suspend is a coroutine function
    @Insert
    suspend fun insertLog(inOutLog: InOutLog)

    @Query("SELECT * FROM in_out_log")
    suspend fun getLogs(): LiveData<List<InOutLog>>
}