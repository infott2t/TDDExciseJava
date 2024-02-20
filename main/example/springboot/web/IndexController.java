package main.example.springboot.web;
/*책, p132쪽 참조. 
 * folder: config, service, domain, web.  
 * class, Controller 2 case. Controller or ApiController.
 *
 *  in there, web folder.
 */

/*
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
    ...
*/
