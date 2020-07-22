package com.example.myblogapp

class Modell {

    internal var title: String=""
    internal var image:String=""
    internal var description:String=""

    fun Model()=Unit

    fun getTitle(): String {
        return title
    }

    fun setTitle(title: String) {
        this.title=title
    }

    fun getImage(): String {
        return image
    }

    fun setImage(image: String) {
        this.image=image
    }

    fun getDescription(): String {
        return description
    }

    fun setDescription(description: String) {
        this.description=description
    }
}