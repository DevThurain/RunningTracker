package com.testing.runningtracker.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RunDAO {
    @Insert
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM running_table ORDER BY timestamp DESC")
    fun getAllRunsSortedByTimestamps() : LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC")
    fun getAllRunsSortedByTimeInMillis() : LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY avgSpeedInKMH DESC")
    fun getAllRunsSortedByAvgSpeed() : LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY calorieBurned DESC")
    fun getAllRunsSortedByCalorieBurned() : LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distanceInMeter DESC")
    fun getAllRunsSortedByDistance() : LiveData<List<Run>>



    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeInMillis() : LiveData<List<Run>>

    @Query("SELECT SUM(calorieBurned) FROM running_table")
    fun getTotalCalorieBurned() : LiveData<List<Run>>

    @Query("SELECT SUM(distanceInMeter) FROM running_table")
    fun getTotalDistance() : LiveData<List<Run>>
}