package com.example.smarthomecontroll.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smarthomecontroll.R
import com.example.smarthomecontroll.models.Device
import com.example.smarthomecontroll.models.RecentActivity
import com.example.smarthomecontroll.activities.DeviceDetailActivity

class DashboardAdapter(
    private val devices: List<Device>,
    private val activities: List<RecentActivity>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_DEVICE = 0
    private val VIEW_TYPE_ACTIVITY = 1

    inner class DeviceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val deviceName: TextView = itemView.findViewById(R.id.device_name)

        fun bind(device: Device) {
            deviceName.text = device.name
            itemView.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, DeviceDetailActivity::class.java)
                intent.putExtra("DEVICE_NAME", device.name)
                context.startActivity(intent)
            }
        }
    }

    inner class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val activityDesc: TextView = itemView.findViewById(R.id.activity_description)

        fun bind(activity: RecentActivity) {
            activityDesc.text = activity.description
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < devices.size) VIEW_TYPE_DEVICE else VIEW_TYPE_ACTIVITY
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_TYPE_DEVICE) {
            val view = inflater.inflate(R.layout.item_device, parent, false)
            DeviceViewHolder(view)
        } else {
            val view = inflater.inflate(R.layout.item_activity, parent, false)
            ActivityViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_DEVICE) {
            (holder as DeviceViewHolder).bind(devices[position])
        } else {
            (holder as ActivityViewHolder).bind(activities[position - devices.size])
        }
    }

    override fun getItemCount(): Int = devices.size + activities.size
}
