package com.ticketfly

class MobileService {

    boolean detect(request) {

        def device = request.getAttribute('currentDevice') // injected by Spring Mobile

        boolean detected = device.isMobile()

        if (detected) {

            def userAgent = request.getHeader('User-Agent')

            if (userAgent?.contains('iPad')) { // skip iPads

                detected = false

            } else if (userAgent?.contains('Android') && !userAgent?.contains('Mobile')) {

                // and android tablets

                detected = false

            }

        }

        detected

    }
}
