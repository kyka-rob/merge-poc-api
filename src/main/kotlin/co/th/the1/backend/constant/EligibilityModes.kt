package co.th.the1.backend.constant

enum class EligibilityModes(
    val type: String
) {
    PUBLIC("public"),
    JUST_FOR_YOU("invite"),
    USER_AFFILIATION("user_affiliation"),
    TIER("tier")
}