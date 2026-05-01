# 도메인 규칙

## 1. 상태 전이

좌석 상태는 아래 전이만 허용한다.

- `AVAILABLE` → `HELD` → `RESERVED`
- `HELD`가 TTL 만료되면 다시 `AVAILABLE`로 돌아간다.
- `RESERVED`는 최종 상태이며, 같은 좌석은 다시 예약할 수 없다.

## 2. 홀드 정책

- 홀드 TTL: 3분
- 홀드 생성 시: `expires_at = 현재시각 + 3분`
- 만료된 홀드로는 예약 확정을 할 수 없다.

## 3. 비즈니스 규칙

- 해당 좌석에 이미 유효한 홀드가 있으면 홀드 생성은 실패한다.
- 좌석이 이미 `RESERVED`이면 홀드 생성·예약 확정 모두 실패한다.
- 예약 확정 시 홀드 소유자(`userId`)가 요청자와 일치해야 한다.

## 4. 정합성 규칙

- 최종 중복 예매 방어: 예약 테이블에서 `(show_id, seat_id)` UNIQUE
- 중복 요청 방어: `idempotency_key` UNIQUE

## 5. 오류 코드

- `HOLD_ALREADY_EXISTS`: 이미 같은 좌석에 유효 홀드 존재
- `SEAT_ALREADY_RESERVED`: 좌석이 이미 예약 완료
- `HOLD_EXPIRED`: 홀드 만료
- `HOLD_NOT_FOUND`: 홀드 없음
- `HOLD_OWNER_MISMATCH`: 홀드 소유자 불일치
