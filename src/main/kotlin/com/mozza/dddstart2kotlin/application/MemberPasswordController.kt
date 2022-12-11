package com.mozza.dddstart2kotlin.application

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Controller

@Controller
@RequestMapping("/member/changePassword")
class MemberPasswordController {

    @PostMapping
    fun submit(request: HttpServletRequest): String {
        try {
            // 응용 서비스가 표현 영역을 의존하면 안된다.
            changePasswordService.changePassword(request)
        } catch (ex: NotFoundException) {
            // Error handling
        }
    }
}