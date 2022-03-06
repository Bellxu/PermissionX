package com.permissionx.bellxu

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity

object PermissionX {

    private const val TAG ="InvisibleFragment"

    fun request(activity: FragmentActivity, vararg permissions:String, callback: PermissionCallback){
        val fragmentManager = activity.supportFragmentManager
        val findFragmentByTag = fragmentManager.findFragmentByTag(TAG)

        val fragment=if (findFragmentByTag!=null){
            findFragmentByTag as InvisibleFragment
        }else{
            val invisibleFragment=InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback,*permissions)
    }
}