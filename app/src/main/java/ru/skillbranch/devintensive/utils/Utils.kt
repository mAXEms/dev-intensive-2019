package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?) : Pair<String?, String?>{
        val parts : List<String>? = fullName?.split(" ")

        val firstName = when( parts?.getOrNull(0)){
            "" ->  null
            else -> parts?.getOrNull(0)
        }
        val lastName = when(parts?.getOrNull(1)){
            "" -> null
            else -> parts?.getOrNull(1)
        }
        //return Pair(firstName, lastName)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider:String = " "): String {
        var result:String = ""
        payload.forEach { letter : Char? ->  result += when
            {
                letter == ' ' -> divider
                else -> if (letter?.isUpperCase() ?: false) transliterationDict(letter)?.replace(transliterationDict(letter)!!.get(0), transliterationDict(letter)?.get(0)!!.toUpperCase()) else transliterationDict(letter)
            }
        }

        return result
    }

    private fun transliterationDict(c: Char?): String? {
        return  when(c?.toLowerCase()){
            'а' -> "a"
            'б' -> "b"
            'в' -> "v"
            'г' -> "g"
            'д' -> "d"
            'е' -> "e"
            'ё' -> "e"
            'ж' -> "zh"
            'з' -> "z"
            'и' -> "i"
            'й' -> "i"
            'к' -> "k"
            'л' -> "l"
            'м' -> "m"
            'н' -> "n"
            'о' -> "o"
            'п' -> "p"
            'р' -> "r"
            'с' -> "s"
            'т' -> "t"
            'у' -> "u"
            'ф' -> "f"
            'х' -> "h"
            'ц' -> "c"
            'ч' -> "ch"
            'ш' -> "sh"
            'щ' -> "sh'"
            'ъ' -> ""
            'ы' -> "i"
            'ь' -> ""
            'э' -> "e"
            'ю' -> "yu"
            'я' -> "ya"
            else -> "$c"
        }

        //return resC
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        return "${firstName?.get(0)}${lastName?.get(0)}"
    }


}