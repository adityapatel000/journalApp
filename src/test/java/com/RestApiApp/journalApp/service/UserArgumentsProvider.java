////package com.RestApiApp.journalApp.service;
////
////import com.RestApiApp.journalApp.entity.UserEntry;
////import net.bytebuddy.description.method.MethodDescription;
////import net.bytebuddy.implementation.MethodCall;
////import org.junit.jupiter.params.provider.Arguments;
////import org.springframework.security.core.userdetails.User;
////
////import java.util.List;
////import java.util.stream.Stream;
////
////public class UserArgumentsProvider implements MethodCall.ArgumentLoader.ArgumentProvider {
////    @Override
////    public List<MethodCall.ArgumentLoader> resolve(MethodDescription methodDescription, MethodDescription methodDescription1) {
////        return Stream.of(
////                Arguments.of(
////                        UserEntry.builder()
////                                .userName("ededede")
////                                .password("shyam")
////                                .build()
////                ),
////                Arguments.of(
////                        UserEntry.builder()
////                                .userName("ededed")
////                                .password("")
////                                .build()
////                )
////        );
////    }
////}
//
//
//package com.RestApiApp.journalApp.service;
//
//import com.RestApiApp.journalApp.entity.UserEntry;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.ArgumentsProvider;
//
//import java.util.stream.Stream;
//
//public class UserArgumentsProvider implements ArgumentsProvider {
//
//    @Override
//    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
//
//        return Stream.of(
//                Arguments.of(
//                        UserEntry.builder()
//                                .userName("ededede")
//                                .password("shyam")
//                                .build()
//                ),
//                Arguments.of(
//                        UserEntry.builder()
//                                .userName("ededed")
//                                .password("")
//                                .build()
//                )
//        );
//    }
//}
