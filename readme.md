# 2025-1-Java-Study Git 가이드

## 1. 브랜치 설명

프로젝트는 크게 세 가지 종류의 브랜치를 사용합니다.

### `main` 브랜치

- **역할:** **서비스에 배포될 수 있는 최종 코드를 관리**하는 브랜치입니다. 가장 안정적인 상태를 유지해야 합니다.
- **규칙:**
    - 긴급한 사유 (예: 서비스 장애 발생) 외에는 이 브랜치에 직접 커밋하는 것을 엄격히 금지합니다.
    - 새로운 기능 개발 또는 버그 수정 코드는 **항상 `dev` 브랜치에서 시작**되어 Merge Request (또는 Pull Request) 과정을 거친 후 `dev` 브랜치로 통합됩니다.
    - `dev` 브랜치에서 충분히 테스트되고 안정성이 확인된 후에만 **`main` 브랜치로 Merge Request (또는 Pull Request)**를 통해 병합합니다.

### `dev` 브랜치

- **역할:** **다음 배포 버전에 포함될 기능들을 통합하는 주 개발 브랜치**입니다. 각자 개발한 기능 브랜치들이 이 브랜치로 병합됩니다.
- **규칙:**
    - 새로운 기능 개발이나 버그 수정 작업은 **항상 이 `dev` 브랜치에서 분기하여 시작**합니다.
    - 개발이 완료된 기능 브랜치들은 `dev` 브랜치로 Merge Request (또는 Pull Request)를 요청하여 코드 리뷰 후 병합합니다.
    - 이 브랜치의 코드는 항상 `main` 브랜치보다는 최신이지만, 배포 가능한 상태가 아닐 수 있습니다. 하지만 기본적인 기능 통합 테스트가 가능해야 합니다.
    - 모든 팀원은 주기적으로 `dev` 브랜치의 최신 상태를 자신의 로컬 저장소로 가져와(Pull) 자신의 작업 브랜치에 통합(Merge 또는 Rebase)하여 코드 충돌을 최소화해야 합니다.

### 기능/수정 브랜치 (`feat/*`, `fix/*`, `hotfix/*` 등)

- **역할:** 특정 **새로운 기능 개발**(`feat/`), **일반적인 버그 수정**(`fix/`), 또는 **긴급한 프로덕션 버그 수정**(`hotfix/`)과 같이 **특정 작업을 수행하기 위해 `dev` 브랜치에서 분기**한 브랜치입니다.
- **규칙:**
    - 브랜치 이름은 작업 내용을 명확히 설명할 수 있도록 작성합니다. (예: `feat/user-login`, `fix/password-reset`, `hotfix/server-error-500`)
    - 이 브랜치에서 개발을 진행하며 커밋합니다.
    - 개발 완료 후, 이 브랜치의 내용을 **`dev` 브랜치로 Merge Request (또는 Pull Request)를 생성**하여 병합을 요청합니다.

## 2. 브랜치 Push 규칙

브랜치를 원격 저장소(`origin`)에 올리는(Push) 규칙입니다.

- 개발 중인 기능/수정 브랜치에서 작업 후 커밋한 내용을 `origin` 저장소의 해당 브랜치로 Push 합니다.
    
    ```bash
    git push origin feat/기능이름
    
    ```
    
- `dev` 브랜치나 `main` 브랜치에는 **절대 로컬에서 직접 Push 하지 않습니다.** 모든 통합은 **Merge Request (또는 Pull Request)를 통해서만 진행**됩니다.

## 3. 기본 개발 워크플로우

### 레포지토리를 처음 받을 때 (또는 새로운 환경에서 시작할 때)

1. 레포지토리를 로컬로 복제(Clone)합니다.
    
    ```bash
    git clone [<https://github.com/KERT-core/KERT_Introduction_Website-BE.git>](<https://github.com/KERT-core/KERT_Introduction_Website-BE.git>)
    
    ```
    
2. 복제한 프로젝트 폴더로 이동합니다.
    
    ```bash
    cd KERT_Introduction_Website-BE
    
    ```
    
3. 주 개발 브랜치인 `dev` 브랜치로 전환합니다.
    
    ```bash
    git switch dev
    # Git 버전이 낮은 경우 git checkout dev
    
    ```
    

### 새로운 기능 개발 또는 버그 수정을 시작할 때

1. **반드시 `dev` 브랜치의 최신 상태로 이동**합니다. (혹시 다른 브랜치에 있었다면 `git switch dev` 또는 `git checkout dev`)
2. `dev` 브랜치의 최신 내용을 원격 저장소에서 가져옵니다.
    
    ```bash
    git pull origin dev
    
    ```
    
3. `dev` 브랜치에서 새로운 기능 또는 수정 브랜치를 생성하고 해당 브랜치로 전환합니다.
    
    ```bash
    git switch -c feat/당신의_기능_이름
    # Git 버전이 낮은 경우 git checkout -b feat/당신의_기능_이름
    # (예: git switch -c feat/user-signup)
    
    ```
    
    - `feat/`, `fix/`, `hotfix/` 접두사를 사용하고 뒤에 작업 내용을 명확하게 작성합니다.

### 개발 작업 중

1. 코드를 수정하고 기능을 개발합니다.
2. 변경 사항을 스테이징 영역에 추가합니다.
    
    ```bash
    git add .
    # 또는 특정 파일/폴더만: git add src/main/java/경로/파일명.java
    
    ```
    
3. 변경 내용을 로컬 저장소에 커밋합니다. **커밋 메시지는 변경 내용을 잘 설명하도록 작성합니다.**
    
    ```bash
    git commit -m "feat: 사용자 회원가입 기능 구현"
    # 또는 "fix: 로그인 오류 수정" 등
    
    ```
    
    - 자주 커밋하여 작업 단위를 작게 유지하는 것이 좋습니다.
4. 개발 중 `dev` 브랜치에 다른 팀원의 변경 사항이 머지되었을 수 있습니다. 주기적으로 `dev` 브랜치의 변경 사항을 자신의 기능 브랜치로 가져와 통합합니다.
    - 현재 기능 브랜치에 있는 상태에서:
    
    ```bash
    git pull origin dev
    
    ```
    
    - 이때 충돌(Conflict)이 발생할 수 있습니다. 충돌을 해결하고 다시 커밋합니다.

### 개발 완료 후 원격 저장소에 올릴 때 (Merge Request 준비)

1. 기능 개발 및 테스트가 완료되면, 해당 기능 브랜치에 모든 변경 사항을 추가하고 커밋합니다.
    
    ```bash
    git add .
    git commit -m "feat: [완료] 사용자 회원가입 기능 구현 및 테스트 완료"
    
    ```
    
2. 자신의 기능 브랜치를 원격 저장소(`origin`)에 푸시합니다.
    
    ```bash
    git push origin feat/당신의_기능_이름
    
    ```
    
3. GitHub 또는 사용하는 Git 호스팅 서비스 웹사이트에서 방금 푸시한 브랜치를 이용하여 **`dev` 브랜치로 향하는 Merge Request (또는 Pull Request)**를 생성합니다.
4. Merge Request 내용을 상세히 작성하고, 필요한 경우 팀원에게 코드 리뷰를 요청합니다.
5. 코드 리뷰를 통해 수정 사항이 발생하면 해당 브랜치에 추가 커밋 후 다시 푸시합니다. Merge Request에 자동으로 반영됩니다.
6. 리뷰 완료 및 승인 후 `dev` 브랜치로 병합(Merge)합니다.

### 다른 사람의 변경 내용을 로컬 `dev` 브랜치로 가져올 때

- 새로운 작업을 시작하기 전이나, `dev` 브랜치의 최신 상태를 확인하고 싶을 때 `git pull` 명령어를 사용합니다.
    
    ```bash
    git switch dev # dev 브랜치로 이동
    git pull origin dev # 원격 dev 브랜치의 최신 내용 가져오기
    
    ```
    

## 4. 사용 기술 스택

본 백엔드 프로젝트에서 사용하는 주요 기술 스택은 다음과 같습니다.

- **Framework:** Spring Boot **3.4.5**
- **Build Tool:** Gradle
- **Language:** Java
- **Database:** MySQL, H2

---