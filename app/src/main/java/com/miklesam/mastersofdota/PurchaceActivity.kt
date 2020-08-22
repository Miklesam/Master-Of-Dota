package com.miklesam.mastersofdota

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.billingclient.api.*
import com.miklesam.mastersofdota.adapters.inapp.MyProductAdapter
import com.miklesam.mastersofdota.datamodels.ProTeamsEnum
import com.miklesam.mastersofdota.utils.InAppEnum
import com.miklesam.mastersofdota.utils.PrefsHelper
import kotlinx.android.synthetic.main.activity_purchace.*

class PurchaceActivity : AppCompatActivity(), PurchasesUpdatedListener {

    lateinit var billingClient: BillingClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchace)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setupBillingClient()
        recycler_product.setHasFixedSize(true)
        recycler_product.layoutManager = LinearLayoutManager(this)
    }

    private fun loadProductToRecycler(skuDetailsList: MutableList<SkuDetails>?) {
        val adapter = MyProductAdapter(this, skuDetailsList!!, billingClient)
        recycler_product.adapter = adapter
    }

    private fun setupBillingClient() {
        billingClient = BillingClient.newBuilder(this).setListener(this).build()
        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingServiceDisconnected() {
                Toast.makeText(
                    this@PurchaceActivity,
                    "You are Disconnect from Billing",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onBillingSetupFinished(responseCode: Int) {
                if (responseCode == BillingClient.BillingResponse.OK) {
                    Toast.makeText(
                        this@PurchaceActivity,
                        "Success to connect Billing",
                        Toast.LENGTH_SHORT
                    ).show()
                    if (billingClient.isReady) {
                        val params = SkuDetailsParams.newBuilder()
                            .setSkusList(
                                listOf(
                                    InAppEnum.BAG_OF_COINS.productId,
                                    InAppEnum.BIG_BAG_OF_COINS.productId,
                                    InAppEnum.SMALL_BOX_OF_MONEY.productId,
                                    InAppEnum.MIDDLE_BOX_OF_MONEY.productId,
                                    InAppEnum.BIG_BOX_OF_MONEY.productId,
                                    InAppEnum.TREASURE.productId,
                                    InAppEnum.GREAT_TREASURE.productId
                                )
                            )
                            .setType(BillingClient.SkuType.INAPP)
                            .build()
                        billingClient.querySkuDetailsAsync(
                            params
                        ) { responseCode, skuDetailsList ->
                            if (responseCode == BillingClient.BillingResponse.OK) {
                                loadProductToRecycler(skuDetailsList)
                            } else {
                                Toast.makeText(
                                    this@PurchaceActivity,
                                    "Can not query products",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                    } else {
                        Toast.makeText(
                            this@PurchaceActivity,
                            "Billing client not ready",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                } else {
                    Toast.makeText(this@PurchaceActivity, "$responseCode", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        })

    }


    override fun onPurchasesUpdated(responseCode: Int, purchases: MutableList<Purchase>?) {

        val listener =
            ConsumeResponseListener { responseCode, purchaseToken ->
                Log.w("Consumed", "Consumed $responseCode -- $purchaseToken")
            }
        if (purchases != null) {

            for (purchase in purchases) {
                billingClient.consumeAsync(purchase.purchaseToken, listener)
                val plusMoney =
                    InAppEnum.values().find { it.productId == purchase.sku }?.plusMoney ?: 0
                val currentMoney = PrefsHelper.read(
                    PrefsHelper.MONEY, "0"
                )?.toInt() ?: 0
                PrefsHelper.write(
                    PrefsHelper.MONEY,
                    (currentMoney + plusMoney).toString()
                )
            }

        }

        Toast.makeText(
            this@PurchaceActivity,
            "Purchase item : ${purchases?.size}",
            Toast.LENGTH_SHORT
        ).show()
    }
}