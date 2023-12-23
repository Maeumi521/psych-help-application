package com.psych_help

import android.graphics.Color
import android.graphics.Typeface
import android.media.tv.TvView
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0

    private lateinit var option_one: TextView
    private lateinit var option_two: TextView
    private lateinit var option_three: TextView
    private lateinit var option_four: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionsList = Constants.getQuestions()
        setQuestion()

        option_one.setOnClickListener(this)
        option_two.setOnClickListener(this)
        option_three.setOnClickListener(this)
        option_four.setOnClickListener(this)
    }

    private fun setQuestion(){
        mCurrentPosition = 1
        val question = mQuestionsList!![mCurrentPosition-1]

        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        val progressText: TextView = findViewById(R.id.progress)
        val quest: TextView = findViewById(R.id.question)


        option_one = findViewById(R.id.option_one)
        option_two = findViewById(R.id.option_two)
        option_three = findViewById(R.id.option_three)
        option_four = findViewById(R.id.option_four)

        defaultOptionsView()

        progressBar.progress = mCurrentPosition
        progressText.text = "$mCurrentPosition" + "/" + progressBar.max

        quest.text = question!!.question
        option_one.text = question.optionOne
        option_two.text = question.optionTwo
        option_three.text = question.optionThree
        option_four.text = question.optionFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, option_one)
        options.add(1, option_two)
        options.add(2, option_three)
        options.add(3, option_four)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background =  ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option_one->{
                selectedOptionView(option_one,1)
            }
            R.id.option_two->{
                selectedOptionView(option_two,2)
            }
            R.id.option_three->{
                selectedOptionView(option_three, 3)
            }
            R.id.option_four->{
                selectedOptionView(option_four,4)
            }
        }
    }

    private fun selectedOptionView(tv:TextView,
                                   selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
}