package com.sowandgrow.app.data

import android.os.Parcel
import android.os.Parcelable

data class Plants(val image:Int, val name:String):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Plants> {
        override fun createFromParcel(parcel: Parcel): Plants {
            return Plants(parcel)
        }

        override fun newArray(size: Int): Array<Plants?> {
            return arrayOfNulls(size)
        }
    }
}
