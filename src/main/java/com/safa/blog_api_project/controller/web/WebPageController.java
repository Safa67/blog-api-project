package com.safa.blog_api_project.controller.web;

import com.safa.blog_api_project.dto.request.BlogPostRequestDto;
import com.safa.blog_api_project.dto.request.CommentRequestDto;
import com.safa.blog_api_project.dto.request.TagRequestDto;
import com.safa.blog_api_project.dto.response.BlogPostResponseDto;
import com.safa.blog_api_project.dto.response.TagResponseDto;
import com.safa.blog_api_project.dto.response.UserResponseDto;
import com.safa.blog_api_project.service.IBlogPostService;
import com.safa.blog_api_project.service.ICategoryService;
import com.safa.blog_api_project.service.ICommentService;
import com.safa.blog_api_project.service.ITagService;
import com.safa.blog_api_project.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebPageController {

    final private IBlogPostService blogPostService;
    final private ITagService tagService;
    final private ICommentService commentService;
    final private IUserService userService;
    final private ICategoryService categoryService;




    @GetMapping("/home")
    public String getHomePage(@RequestParam(required = false) String tagName,
                              @RequestParam(required = false) String keyword,
                              @RequestParam(required = false) String categoryName,
                              @RequestParam(defaultValue = "0") int page,
                              Model model) {

        List<BlogPostResponseDto> fetchedBlogs;
        int size = 10;

        if (keyword != null && !keyword.isEmpty()) {
            fetchedBlogs = blogPostService.searchBlogs(keyword, page, size);
        }
        else if (tagName != null && !tagName.isEmpty()) {
            fetchedBlogs = blogPostService.getBlogsByTagName(tagName, page, size);
        }
        else if (categoryName != null && !categoryName.isEmpty()) {
            fetchedBlogs = blogPostService.getBlogsByCategoryName(categoryName, page, size);
        }
        else {
            fetchedBlogs = blogPostService.getAllBlogPost(page, size);
        }

        model.addAttribute("blogs", fetchedBlogs);
        model.addAttribute("currentPage", page);
        model.addAttribute("hasNext", fetchedBlogs.size() == size);
        
        List<TagResponseDto> fetchedTags = tagService.getAllTag();
        model.addAttribute("tags", fetchedTags);

        return "index";
    }

    @GetMapping("/blog/{id}")
    public String getBlogDetail(@PathVariable Long id, Model model){
        BlogPostResponseDto blogPostResponseDto = blogPostService.getBlogPostById(id);
        model.addAttribute("blog", blogPostResponseDto);
        List<UserResponseDto> users = userService.findAllUser(0, 50);
        model.addAttribute("users", users);
        return "post-details";
    }

    @PostMapping("/blog/{id}/comment")
    public String addComment(@PathVariable Long id, @ModelAttribute CommentRequestDto commentRequestDto) {
        commentRequestDto.setBlogId(id);

        UserResponseDto author = userService.findUserById(commentRequestDto.getAuthorId());
        commentRequestDto.setCommenterName(author.getUsername());
        
        commentService.createComment(commentRequestDto);
        return "redirect:/blog/" + id;
    }


    @GetMapping("/create-post")
    public String getCreatePostPage(Model model) {
        model.addAttribute("categories", categoryService.getCategoryAll());
        model.addAttribute("tags", tagService.getAllTag());
        model.addAttribute("users", userService.findAllUser(0, 50));
        return "create-post";
    }

    @PostMapping("/create-post")
    public String createPost(@ModelAttribute BlogPostRequestDto blogPostRequestDto) {
        blogPostService.createBlogPost(blogPostRequestDto);
        return "redirect:/home";
    }

    @PostMapping("/create-tag")
    public String createTag(@ModelAttribute TagRequestDto tagRequestDto) {
        tagService.createTag(tagRequestDto);
        return "redirect:/create-post";
    }

    @GetMapping("/categories")
    public String getCategoriesPage(Model model) {
        model.addAttribute("categories", categoryService.getCategoryAll());
        return "categories";
    }

}
