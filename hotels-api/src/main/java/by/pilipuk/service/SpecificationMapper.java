package by.pilipuk.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

public class SpecificationMapper {
//    public final class TransactionSpecifications {
//
//        private TransactionSpecifications() {
//        }
//
//        public static Specification<Transaction> withFilters(
//            Collection<TransactionType> types,
//            Long userId,
//            LocalDateTime createdAtFrom,
//            LocalDateTime createdAtTo,
//            BigDecimal sumFrom,
//            BigDecimal sumTo
//        ) {
//            return Specification
//                .where(hasTypes(types))
//                .and(hasUserId(userId))
//                .and(createdAtFrom(createdAtFrom))
//                .and(createdAtTo(createdAtTo))
//                .and(sumFrom(sumFrom))
//                .and(sumTo(sumTo));
//        }
//
//        private static Specification<Transaction> hasTypes(
//            Collection<TransactionType> types
//        ) {
//            return (root, query, cb) ->
//                (types == null || types.isEmpty())
//                    ? cb.conjunction()
//                    : root.get(Transaction_.type).in(types);
//        }
//
//        private static Specification<Transaction> hasUserId(Long userId) {
//            return (root, query, cb) ->
//                userId == null
//                    ? cb.conjunction()
//                    : cb.equal(root.get(Transaction_.userId), userId);
//        }
//
//        private static Specification<Transaction> createdAtFrom(
//            LocalDateTime from
//        ) {
//            return (root, query, cb) ->
//                from == null
//                    ? cb.conjunction()
//                    : cb.greaterThanOrEqualTo(
//                        root.get(Transaction_.transactionCreatedAt), from
//                    );
//        }
//
//        private static Specification<Transaction> createdAtTo(
//            LocalDateTime to
//        ) {
//            return (root, query, cb) ->
//                to == null
//                    ? cb.conjunction()
//                    : cb.lessThanOrEqualTo(
//                        root.get(Transaction_.transactionCreatedAt), to
//                    );
//        }
//
//        private static Specification<Transaction> sumFrom(BigDecimal from) {
//            return (root, query, cb) ->
//                from == null
//                    ? cb.conjunction()
//                    : cb.greaterThanOrEqualTo(root.get(Transaction_.sum), from);
//        }
//
//        private static Specification<Transaction> sumTo(BigDecimal to) {
//            return (root, query, cb) ->
//                to == null
//                    ? cb.conjunction()
//                    : cb.lessThanOrEqualTo(root.get(Transaction_.sum), to);
//        }
    }
}
