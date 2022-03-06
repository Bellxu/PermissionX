package com.example.permissionx

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.permissionx.bellxu.InvisibleFragment
import com.permissionx.bellxu.PermissionX

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun call(view: android.view.View) {
        PermissionX.request(this,Manifest.permission.CALL_PHONE){
            allGranted,deniedList->
            if (allGranted) {
                doCall()
            }else{
                Toast.makeText(this,"权限被拒:$deniedList",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun doCall() {
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data= Uri.parse("tel:10086")
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}