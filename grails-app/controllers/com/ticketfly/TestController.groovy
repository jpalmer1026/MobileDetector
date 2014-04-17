package com.ticketfly

class TestController {

    def mobileService

    def afterInterceptor = [action: this.&handleMobile] // using interceptor instead of filter because of [GRAILS-6555]

    def index() {
//        def view = "list"
//        withMobileDevice { device ->
//            view = "mobileList"
//        }
//        render(view: view)
    }

    private handleMobile(model, modelAndView) {
        if (modelAndView && mobileService.detect(request)) {  // use modelAndView to change the view for mobile requests
            modelAndView.viewName = '/mobile/' + modelAndView.viewName // mobile views will be put under mobile directory
        }
    }
}
