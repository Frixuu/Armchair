package xyz.lukasz.armchair.common.minecraft

import spock.lang.Specification

class ValidationSpec extends Specification {

    def "Usernames are valid only if they comply to Mojang rules"(def username, def valid) {
        when:
        def result = Validation.isValidUsername(username)
        then:
        result == valid
        where:
        username                     | valid
        "Frixuu"                     | true
        "xVeenix"                    | true
        "Steve#8"                    | false   // invalid character
        "Daniel B"                   | false   // invalid character
        "Cool.J"                     | false   // invalid character
        "_Meganka_"                  | true
        "-_-xXx-_-"                  | false   // invalid character
        "aa"                         | false   // name too short
        "CoaxİalCable"               | false   // invalid character
        "smok8881"                   | true
        "IvanderSchreckliche"        | false   // name too long
        "dont forget about ^ and \$" | false   // too long; invalid characters
    }
}