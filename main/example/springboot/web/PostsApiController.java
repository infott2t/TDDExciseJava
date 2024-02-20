package main.example.springboot.web;

/* 책, p111쪽 참조. 
 * folder: config, service, domain, web.  
 * class, Controller 2 case. Controller or ApiController.
 * in there, web folder.
*/

/*
@RequiredArgsConstructor
@RestController
public class PostsApiController {
    
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

}
*/