package com.example.lifecycle

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondScreen : AppCompatActivity() {
    private lateinit var indexTV : TextView
    private lateinit var bodytypeIV : ImageView
    private lateinit var recommendationsTV: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun index(height: Double?, weight: Int?) = weight?.div((height?.times(height)!!))
        val height = intent.getStringExtra("height")?.toDouble()
        val weight = intent.getStringExtra("weight")?.toInt()

        indexTV = findViewById(R.id.indexTV)
        bodytypeIV = findViewById(R.id.bodytypeIV)
        recommendationsTV = findViewById(R.id.recommendationsTV)

        indexTV.text = index(height, weight).toString()

        if (indexTV.text.toString().toDouble() in 18.5..24.9) {
            bodytypeIV.setImageResource(R.drawable.normal)
            recommendationsTV.text = "У вас нормальный индекс массы тела! \n Продолжайте вести здоровый образ жизни."
        } else if (indexTV.text.toString().toDouble() > 24.9) {
            bodytypeIV.setImageResource(R.drawable.overweight)
            recommendationsTV.text = "Пациенту, желающему снизить свой вес РЕКОМЕНДУЕТСЯ :\n" +
                    "\n" +
                    "-проводить  самоконтроль  массы тела (желательно, чтобы пациент имел домашние весы),\n" +
                    "\n" +
                    "- знать свой и  рекомендуемый для  нормы индекс массы тела:\n" +
                    "\n" +
                    "Нормальная масса тела 18,5 – 24,9\n" +
                    "\n" +
                    "Избыточная масса тела 25 – 29,9\n" +
                    "\n" +
                    "Ожирение I степени 30,0 – 34,9\n" +
                    "\n" +
                    "Ожирение II степени 35,0 – 39,9\n" +
                    "\n" +
                    "Ожирение III степени≥ 40\n" +
                    "\n" +
                    "- знать окружности талии : цель - окружность талии для мужчин менее 94 см, для женщин – менее 80 см, но через промежуточную цель- окружность талии для мужчин менее 102 см, для женщин – менее 88 см\n" +
                    "\n" +
                    "-знать основы рационального питания и особенностей питания при избыточной массе тела- екомендуется ограничение поваренной соли до 5 г/сутки (1 чайная ложка без верха), исключив приправы, специи, алкоголь. Рекомендуется предпочтение отдавать отвариванию, припусканию, тушению в собственном соку, обжариванию в специальной посуде без добавления жиров, сахара, соли, приготовлению на пару, в духовке, в фольге или пергаменте, на гриле, без дополнительного использования жиров. Не следует злоупотреблять растительными маслами, майонезом при приготовлении салатов. Рекомендуется 3 основных приема пищи (завтрак, обед и ужин) и 1-2 перекуса в день. Ужин рекомендуется не позднее, чем за 3-4 часа до сна. Оптимальный интервал между ужином и завтраком – 10 часов. В программах снижения избыточного веса можно предусмотреть разгрузочные дни (1-2 раза в неделю)."
        } else if (indexTV.text.toString().toDouble() < 18.5) {
            bodytypeIV.setImageResource(R.drawable.underweight)
            recommendationsTV.text = "Общие рекомендации при борьбе с дефицитом веса: \n Улучшить аппетит. Сделать это можно при помощи красивой сервировки стола, использование красного цвета на кухне, который пробуждает аппетит. Также стоит каждый день баловать себя любимым блюдом. Способствуют хорошему аппетиту долька лимона или настой полыни, продолжительная прогулка на свежем воздухе.\n" +
                    "Нормализовать режим питания. Кушать следует ежедневно в одно и то же время, небольшими порциями. Такой подход помогает улучшить усвоение пищи. Между приемами пищи обязательно должны быть небольшие перекусы. Обязателен ежедневный завтрак, который богат на белки и сложные углеводы.\n" +
                    "Употреблять здоровую калорийную пищу. Основу рациона должны составлять продукты, богатые на питательные вещества. Это мясо и рыба, овощи и фрукты, молочная продукция, яйца. При этом рекомендуется отказаться от консервированной, жареной, острой, жирной пищи, которая «засоряет» организм.\n" +
                    "Заниматься спортом для наращивания мышечной массы. Рекомендуется обсудить программу тренировок с тренером, который поможет подобрать необходимые упражнения.\n" +
                    "Пить специальные чаи, которые стимулируют чувство голода. Это настой с полынью, отвар шиповника, чай с бергамотом и ромашкой.\n" +
                    "Заниматься йогой. Тренировки помогают восстановить работу нервной и сосудистой системы, улучшить настроение и справиться с депрессией, суставными и мышечными болями.\n" +
                    "Обеспечить продолжительный и комфортный сон, который способствует улучшению психоэмоционального состояния, снимает стресс, нормализует работу внутренних органов, повышает аппетит. Длительность сна должна быть не менее 8 часов."
        }
    }
}