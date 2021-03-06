package xyz.lukasz.armchair.common.minecraft

import spock.lang.Specification

class UuidsSpec extends Specification {

    def "Well-known offline mode UUIDs are generated correctly"(def username, def expected) {
        given:
        def expectedUuid = UUID.fromString(expected)
        when:
        def result = Uuids.getOfflineFromUsername(username)
        then:
        result == expectedUuid
        where:
        username     | expected
        "barpec2"    | "b0c5ce53-fe41-314c-8162-95a8433f6d66"
        "dominek087" | "8a998aa4-9be1-33b8-9067-ac366cf6b67f"
        "optifajn"   | "283b0500-6a4d-3f24-a740-a0c9d9142d7a"
        "Vapiq"      | "b77f852a-5db9-3885-a2fa-6c54025096e4"
    }
}
