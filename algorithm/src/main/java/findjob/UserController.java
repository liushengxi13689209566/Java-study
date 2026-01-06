//package findjob;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.annotation.Resource;
//
//@RequestMapping("/user")
//@Controller
//public class UserController {
//    @Resource
//    private ServiceLmpl userService;
//
//    @GetMapping("/queryById")
//    public Result getUserInfoById(@RequestParam Long  id){
//        try {
//            if(id <0 || id > 100000){
//                return Result(-1,"cdvcj","csbdc");
//            }
//            UserEntity userEntity = userService.selectUserInfoById(id);
//            if(userEntity == null){
//                return Result(-2,"cdvcj","csbdc");
//            }
//            return Result(0,"success",UserEntity);
//        }catch (Exception exception){
//            log.error("vfhbvbdhvbds")
//            return Result(-100," error ","cdbjcb");
//        }
//    }
//}
