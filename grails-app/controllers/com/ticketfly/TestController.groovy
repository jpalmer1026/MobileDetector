package com.ticketfly

class TestController {

    def mobileService

    def afterInterceptor = [action: this.&handleMobile]

    private handleMobile(model, modelAndView) {

        if (modelAndView && mobileService.detect(request)) {

            modelAndView.viewName = '/mobile/' + modelAndView.viewName

        }

    }
}
