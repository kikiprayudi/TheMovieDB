package kiki.prayudi.themoviedb

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.ashokvarma.gander.Gander
import com.ashokvarma.gander.persistence.GanderPersistence
import kiki.prayudi.themoviedb.module.Module.injectionModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : MultiDexApplication() {

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