package com.lutfullayevmuhammad.quran.core.appimport com.lutfullayevmuhammad.quran.core.di.components.DaggerAppComponentimport dagger.android.AndroidInjectorimport dagger.android.support.DaggerApplicationclass App : DaggerApplication() {    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {        return DaggerAppComponent.builder().application(this).build()    }}