package com.hitokarakishin.percentagequiz

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
//import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
//import sun.jvm.hotspot.utilities.IntArray
//import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Button
//import sun.jvm.hotspot.utilities.IntArray
//import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.system.Os.remove
//import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
//import sun.jvm.hotspot.utilities.IntArray
import java.util.*
import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.rewarded.RewardedAd;
//import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
//import sun.jvm.hotspot.utilities.IntArray
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
//import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
//import sun.jvm.hotspot.utilities.IntArray
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd

//import sun.jvm.hotspot.utilities.IntArray








class MainActivity : AppCompatActivity() {

    var quizCount = 1
//    private var rewardedAd: RewardedAd? = null
    private lateinit var mInterstitialAd: InterstitialAd


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}

        mInterstitialAd = InterstitialAd(this)
//        //テスト広告
//        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        //本番広告
        mInterstitialAd.adUnitId = "ca-app-pub-3367290713439388/2201800316"

        //広告読み込み
        mInterstitialAd.loadAd(AdRequest.Builder().build())

//        rewardedAd = RewardedAd(
//            this,
//            "ca-app-pub-3940256099942544/5224354917"
//        )
//        val adLoadCallback = object : RewardedAdLoadCallback() {
//            override fun onRewardedAdLoaded() {
//                // Ad successfully loaded.
//            }
//
//            override fun onRewardedAdFailedToLoad(errorCode: Int) {
//                // Ad failed to load.
//            }
//        }
//        rewardedAd!!.loadAd(AdRequest.Builder().build(), adLoadCallback)

//        realm = Realm.getDefaultInstance()

//        answerBtn1?.text = quizData.get(n)

//        //keyを設定して
//        val id = 1
//        //initしたインスタンスをとってきて、トランザクションで書き込み
//        realm.executeTransaction { realm ->
//            val obj = realm.createObject(QuizData::class.java!!, id)
//            obj.item = "婚姻率"
//            obj.percentage = 5.0
//        }
//
//        val id1 = realm.where(QuizData::class.java).equalTo("id", "1").findFirst()
//        println(id1)

        val percentage= mutableListOf(
            4.7,
            8.2,
            10.0,
            13.6,
            18.2,
            35.1,
            37.3,
            38.7,
            41.7,
            45.8,
            46.7,
            50.0,
            53.7,
            55.0,
            59.0,
            65.4,
            70.0,
            84.3,
            80.0,
            64.9,
            84.0,
            83.7,
            84.9,
            86.5,
            88.5,
            91.3,
            99.0,
            100.0
        )
        val item = mutableListOf(
            "婚姻率",
            "セクシュアルマイノリティの割合",
            "戦国時代の戦場で石で殺される割合",
            "全国空き家率",
            "世界の中国人の割合",
            "離婚率",
            "日本の食料自給率",
            "イチローの年度別最高打率",
            "受刑者のうち中卒の割合",
            "平均年収（441万円）以上の人の割合",
            "宝くじの当選金還元率",
            "尾崎豊アルバム「十七歳の地図」からのシングルカット率",
            "日本の大学進学率",
            "第一印象のうち視覚の割合",
            "平均寿命までの生存率",
            "軍艦島クルーズ夏の上陸率",
            "新企業10年後生存率",
            "オールブラックス（ラグビーNZ代表）の勝率",
            "2つのことを同時にやるときの作業効率",
            "財布の忘れ物が持ち主に戻る確率",
            "日本のプラスチックごみのリサイクル率",
            "パチンコ・パチスロの還元率",
            "藤井聡太の勝率",
            "Mr.Childrenのシングルオリコン1位率",
            "東京ドーム年間稼働率",
            "ナダルのクレーコート通算勝率",
            "ブラックジャックの還元率",
            "中国の卓球W杯団体戦勝率"
        )

        //ランダムでn番目を決定
        val n = Random().nextInt(percentage.count())

        //nとの重複データなしのリストを新規作成
        val percentage2 = mutableListOf<Double?>()
        val item2 = mutableListOf<String?>()
        percentage2.addAll(percentage)
        item2.addAll(item)

        //nとの重複データを削除
        percentage2.removeAt(n)
        item2.removeAt(n)

        val n2 = Random().nextInt(percentage2.count())

//        //確認用
//        for (i in item) {println( "applog_item: " + i) }
//        for (i in percentage) {println( "applog_percentage: " + i) }
//        for (i in item2) {println( "applog_item2: " + i) }
//        for (i in percentage2) {println( "applog_percentage2: " + i) }

    answerBtn1.text = item.get(n)
    answerBtn2.text = item2.get(n2)


        resetButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            //広告
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
                //広告閉じた時にリセット
                mInterstitialAd.adListener = object: AdListener() {
                    override fun onAdClosed() {
                        // Code to be executed when the interstitial ad is closed.
                        quizCount += 1
                        println("quizCount:"+quizCount)
                        startActivity(intent)

                    }
                }
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.")
            }



        }



        answerBtn1.setOnClickListener {
            if(percentage.get(n)> percentage2.get(n2)!!){
//                resultTextView.setTextColor(Color.RED)
//                resultTextView.text = "正解"
                answerBtn1.text = "○ "+item.get(n)
                answerBtn2.text = "× "+item2.get(n2)
                answerBtn1.setBackgroundColor(Color.argb(255,168,227,171))
                answerBtn2.setBackgroundColor(Color.argb(255,255,209,192))
            }else{
//                resultTextView.setTextColor(Color.BLUE)
//                resultTextView.text = "不正解"
                answerBtn1.text = "× "+item.get(n)
                answerBtn2.text = "○ "+item2.get(n2)
                answerBtn2.setBackgroundColor(Color.argb(255,168,227,171))
                answerBtn1.setBackgroundColor(Color.argb(255,255,209,192))
            }
            kaisetsuTextView1.text = percentage.get(n).toString()+"%"
            kaisetsuTextView2.text = percentage2.get(n2).toString()+"%"
            println("n:"+percentage.get(n)+" n2:"+percentage2.get(n2)!!)
        }

        answerBtn2.setOnClickListener {
            if(percentage.get(n)< percentage2.get(n2)!!){
//                resultTextView.setTextColor(Color.RED)
//                resultTextView.text = "正解"
                answerBtn1.text = "× "+item.get(n)
                answerBtn2.text = "○ "+item2.get(n2)
                answerBtn2.setBackgroundColor(Color.argb(255,168,227,171))
                answerBtn1.setBackgroundColor(Color.argb(255,255,209,192))
            }else{
//                resultTextView.setTextColor(Color.BLUE)
//                resultTextView.text = "不正解"
                answerBtn1.text = "○ "+item.get(n)
                answerBtn2.text = "× "+item2.get(n2)
                answerBtn1.setBackgroundColor(Color.argb(255,168,227,171))
                answerBtn2.setBackgroundColor(Color.argb(255,255,209,192))
            }
            kaisetsuTextView1.text = percentage.get(n).toString()+"%"
            kaisetsuTextView2.text = percentage2.get(n2).toString()+"%"
            println("n:"+percentage.get(n)+" n2:"+percentage2.get(n2)!!)

        }

    }

//    override fun onDestroy(){
//        super.onDestroy()
//        realm.close()
//    }
}