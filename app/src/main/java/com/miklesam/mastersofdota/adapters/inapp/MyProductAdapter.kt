package com.miklesam.mastersofdota.adapters.inapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.SkuDetails
import com.miklesam.mastersofdota.PurchaceActivity
import com.miklesam.mastersofdota.R

class MyProductAdapter(
    val activity: PurchaceActivity,
    val skuDetails: List<SkuDetails>,
    val billingClient: BillingClient
) : RecyclerView.Adapter<MyProductAdapter.MyViewHolder>() {
    class MyViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val textProduct: TextView = itemView.findViewById(R.id.txt_product_name)
        val plusMoney: TextView = itemView.findViewById(R.id.plusMoney)
        lateinit var iInnAppProductListener: InnAppProductListener

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            iInnAppProductListener.onProductClickListener(itemView, adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_product_item, parent, false)
        return MyViewHolder(
            itemView
        )
    }

    override fun getItemCount(): Int {
        return skuDetails.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textProduct.text = skuDetails[position].title
        holder.plusMoney.text = when (position) {
            0 -> "+5000"
            1 -> "+1000"
            else -> "+0"
        }
        holder.iInnAppProductListener = object : InnAppProductListener {
            override fun onProductClickListener(view: View, position: Int) {
                val billingFlowParams = BillingFlowParams.newBuilder()
                    .setSkuDetails(skuDetails[position])
                    .build()
                billingClient.launchBillingFlow(activity, billingFlowParams)
            }

            override fun onClick(p0: View?) {
                Log.w("Clicked", "Click Click")
            }
        }
    }

}