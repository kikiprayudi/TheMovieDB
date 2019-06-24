package kiki.prayudi.themoviedb

import android.app.Application
import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco
import kiki.prayudi.themoviedb.module.Module.injectionModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        private lateinit var instance: App

        val context: Context
            get() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidContext(this@App)
            modules(injectionModule)
        }

        Fresco.initialize(this)
    }
}