package com.psych_help

object Constants{
    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(1, "How often do you feel overwhelmed or stressed?",
            "Rarely", "Occasionally", "Frequently", "Constantly"
            )

        questionsList.add(que1)
        return questionsList

        val que2 = Question(2, "Do you have difficulty sleeping?",
            "Rarely", "Occasionally", "Frequently", "Constantly"
        )

        questionsList.add(que1)
        return questionsList

        val que3 = Question(2, "Are you able to enjoy activities you used to find pleasurable?",
            "Rarely", "Occasionally", "Frequently", "Constantly"
        )

        questionsList.add(que1)
        return questionsList

        val que4 = Question(2, "Do you find it challenging to concentrate or make decisions?",
            "Rarely", "Occasionally", "Frequently", "Constantly"
        )

        questionsList.add(que1)
        return questionsList

        val que5 = Question(2, "How often do you experience feelings of sadness or hopelessness?",
            "Rarely", "Occasionally", "Frequently", "Constantly"
        )

        questionsList.add(que1)
        return questionsList
    }
}