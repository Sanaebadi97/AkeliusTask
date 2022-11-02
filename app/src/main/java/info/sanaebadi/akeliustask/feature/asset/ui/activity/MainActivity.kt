package info.sanaebadi.akeliustask.feature.asset.ui.activity

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import info.sanaebadi.akeliustask.base.BaseActivity
import info.sanaebadi.akeliustask.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}