package sam.samyups.util

import androidx.room.TypeConverter

class TypeConverter {
    @TypeConverter
    fun fromAnyType(value: Any): String {
        return value.toString()
    }
}