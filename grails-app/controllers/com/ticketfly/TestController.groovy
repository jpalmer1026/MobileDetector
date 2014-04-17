package com.ticketfly

class TestController {

    def mobileService

    def afterInterceptor = [action: this.&handleMobile]

    private handleMobile(model, modelAndView) {

        if (modelAndView && mobileService.detect(request)) {  // use mobileAndView to change the view for mobile

            modelAndView.viewName = '/mobile/' + modelAndView.viewName

        }

    }
}
