package com.tekion.cricket.util;
//
//import org.springframework.stereotype.Component;
//
//@Component
//class Mapper {
//    public UserDTO toDto(User user) {
//        String name = user.getName();
//        List<String> roles = user
//                .getRoles()
//                .stream()
//                .map(Role::getName)
//                .collect(toList());
//
//        return new UserDTO(name, roles);
//    }
//
//    public User toUser(UserCreationDTO userDTO) {
//        return new User(userDTO.getName(), userDTO.getPassword(), new ArrayList<>());
//    }
//}