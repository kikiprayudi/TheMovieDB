package kiki.prayudi.themoviedb

import android.app.Application
import android.content.Context
import com.ashokvarma.gander.Gander
import com.ashokvarma.gander.persistence.GanderPersistence
import kiki.prayudi.themoviedb.module.Module.injectionModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        private lateinit var instance: App

        val context: Context
            get() = instance
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        Gander.setGanderStorage(GanderPersistence.getInstance(this))

        startKoin {
            androidContext(this@App)
            modules(injectionModule)
        }
    }
}