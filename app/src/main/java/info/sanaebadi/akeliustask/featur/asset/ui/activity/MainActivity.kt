package info.sanaebadi.akeliustask.featur.asset.ui.activity

import android.os.Bundle
import info.sanaebadi.akeliustask.base.BaseActivity
import info.sanaebadi.akeliustask.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}