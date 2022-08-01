package ca.sfu.BlueRadar.ui.devices

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ca.sfu.BlueRadar.R
import ca.sfu.BlueRadar.ui.devices.data.Device
import com.google.android.material.switchmaterial.SwitchMaterial


class DeviceRecyclerAdapter(private val context: Context, private var deviceList: List<Device>) :
    RecyclerView.Adapter<DeviceRecyclerAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = View.inflate(context, R.layout.devices_card, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currItem = deviceList[position]
        //holder.imageView.setImageResource(ItemsViewModel.image)
        holder.deviceNameTextView.text = currItem.deviceName

        if (currItem.deviceTracking) {
            holder.deviceIsTrackingTextView.text = "Tracking"
            holder.deviceIsTrackingTextView.setTextColor(Color.GREEN)
            holder.trackingSwitch.isChecked = true
        } else {
            holder.deviceIsTrackingTextView.text = "Not Tracking"
            holder.deviceIsTrackingTextView.setTextColor(Color.GRAY)
        }
        //Uncomment when deviceConnected is implemented
        if(currItem.deviceConnected){
            holder.deviceStatusTextView.text = "Connected"
            holder.deviceStatusTextView.setTextColor(Color.GREEN)
        }
        else{
            holder.deviceStatusTextView.text = "Not Connected"
            holder.deviceStatusTextView.setTextColor(Color.RED)
        }


        holder.trackingSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                //Set the tracking to true here and update the database
                holder.deviceIsTrackingTextView.text = "Tracking"
                holder.deviceIsTrackingTextView.setTextColor(Color.GREEN)
            } else {
                //Set the tracking to false here and update the database
                holder.deviceIsTrackingTextView.text = "Not Tracking"
                holder.deviceIsTrackingTextView.setTextColor(Color.GRAY)
            }
        }

        holder.navButton.setOnClickListener{
            //Start the location tracking service
        }
    }

    override fun getItemCount(): Int {
        return deviceList.size
    }

    fun replace(newExerciseEntryList: List<Device>) {
        deviceList = newExerciseEntryList
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        //val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val deviceNameTextView: TextView = itemView.findViewById(R.id.deviceNameTextView)
        val deviceStatusTextView: TextView = itemView.findViewById(R.id.deviceStatusTextView)
        val deviceIsTrackingTextView: TextView = itemView.findViewById(R.id.deviceTrackingTextView)
        val trackingSwitch: SwitchMaterial = itemView.findViewById(R.id.trackingSwitch)
        val editButton: ImageButton = itemView.findViewById(R.id.editButton)
        val navButton: ImageButton = itemView.findViewById(R.id.navigateButton)
        val syncButton: ImageButton = itemView.findViewById(R.id.syncButton)
        val delButton: ImageButton = itemView.findViewById(R.id.deleteButton)
    }

}