package com.dong.android.workmanagertest.hilt

import android.content.Context
import androidx.room.Room
import com.dong.android.workmanagertest.room.AppDataBase
import com.dong.android.workmanagertest.room.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideRoomDataBase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "item").build()
    }

    @Provides
    @Singleton
    fun provideItemDao(appDatabase: AppDataBase): ItemDao {
        return appDatabase.itemDao()
    }
}