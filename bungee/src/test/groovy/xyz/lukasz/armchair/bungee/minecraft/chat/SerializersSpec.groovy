package xyz.lukasz.armchair.bungee.minecraft.chat

import spock.lang.Specification

class SerializersSpec extends Specification {

    def "Bungee chat components are cached"() {
        given:
        def text1 = "&cHello &l&6world!"
        def text2 = "&2I'm something else!"
        def text3 = new StringBuilder("&cHello ").append("&l&6world!").toString()
        when:
        def comp1 = Serializers.toChat(text1)
        def comp2 = Serializers.toChat(text2)
        def comp3 = Serializers.toChat(text3)
        then:
        comp1 !== comp2
        comp2 !== comp3
        comp3 === comp1
    }
}
