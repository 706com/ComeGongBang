<template>
  <div class="MyPageSideBar" style="margin-top: 20px">
    <div data-v-095dc081="" class="MyPageSidebarDesktop w-[180px]">
      <!---------------------------------사이드바 상단 프로필------------------------------------------->
      <div
        data-v-095dc081=""
        class="MyPageProfileDesktop h-fit flex flex-col items-center py-[28px] border-t-[1px] border-x-[1px] border-b-[0] border-[#ff7b30] profile-area"
      >
        <!-- 프로필이미지 -->
        <label
          data-v-b4eb4e33=""
          for="profileImageInput"
          class="MyProfileImageUploader group"
          :style="`--profile-image: url(${
            memberStore.member.profileImageUrl ||
            'https://ajh-project.s3.ap-northeast-2.amazonaws.com/member/default_profile.png'
          });`"
        >
          <div data-v-b4eb4e33="" class="MyProfileImageUploader__image"></div>
          <!-- <input
            data-v-b4eb4e33=""
            id="profileImageInput"
            hidden=""
            type="file"
            name="image"
            accept=".png, .jpg, .jpeg"
          /><span
            data-v-b4eb4e33=""
            class="MyProfileImageUploader__edit group-hover:inline-block"
            for="profileImageInput"
            >수정</span
          > -->
        </label>
        <!-- 프로필 등급 -->
        <div class="flex justify-center align-middle mt-[20px]">
          <img
            :src="memberStore.member.gradeImageUrl"
            width="24"
            height="24"
            class="flex my-auto"
          />
          <router-link
            to="/grade"
            data-v-524f63ea=""
            data-v-8493c3f2=""
            type="default"
            class="CoreButton BaseButtonText body1-regular-small !pr-0"
            style="
              background-color: transparent;
              color: black;
              height: 32px;
              flex-direction: row-reverse;
              --core-button-padding-x: 8;
              font-weight: bold;
            "
          >
            <svg
              data-v-6d2bd019=""
              data-v-524f63ea=""
              width="24"
              height="24"
              viewBox="0 0 24 24"
              xmlns="http://www.w3.org/2000/svg"
              class="BaseIcon CoreButton__icon"
              style="
                width: 18px;
                height: 18px;
                opacity: 1;
                fill: currentcolor;
                --BaseIcon-color: #333333;
                margin-left: 0px;
              "
            >
              <g clip-path="url(#clip0_124_2947)">
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M9.53039 5.46973L15.5304 11.4697C15.7967 11.736 15.8209 12.1527 15.603 12.4463L15.5304 12.5304L9.53039 18.5304L8.46973 17.4697L13.9391 12.0001L8.46973 6.53039L9.53039 5.46973Z"
                ></path>
              </g>
              <defs>
                <clipPath id="clip0_124_2947">
                  <rect width="24" height="24"></rect>
                </clipPath>
              </defs>
            </svg>
            <div data-v-524f63ea="" class="inline-flex items-center">
              <span data-v-524f63ea="" class="CoreButton__text">
                {{ memberStore.member.gradeName }}
              </span>
            </div>
          </router-link>
        </div>
        <!-- 프로필 아이디 -->
        <p
          class="body1-bold-small text-center my-[10px] break-all w-[140px] text-ellipsis overflow-hidden whitespace-nowrap"
        >
          {{ memberStore.member.nickname }}
        </p>
      </div>
      <p
        data-v-095dc081=""
        class="block px-[16px] py-[9px] text-white bg-[#ff7b30] body1-bold-medium"
        style="margin: 0"
      >
        MY MENU
      </p>
      <!---------------------------사이드바 하단 목록------------------------------------->
      <!-- href="https://localhost:3000/order-list" -->
      <nav data-v-095dc081="" class="bg-[#fbfafa]">
        <!---------------------주문-------------------------->
        <div
          data-v-095dc081=""
          class="border-solid border-b border-[#efe8e6] last:border-b-0 py-[11px] px-[16px]"
        >
          <span data-v-095dc081="" class="body2-bold-medium">주문 배송</span>
          <router-link to="/order-list" data-v-095dc081="">
            <div data-v-095dc081="" class="flex flex-col">
              <span
                data-v-095dc081=""
                class="body3-regular-small MyPageSidebarDesktop__menu"
                >주문/배송 내역</span
              >
            </div>
          </router-link>
        </div>
        <!---------------------알림-------------------------->
        <!-- <div data-v-095dc081="" class="border-solid border-b border-[#efe8e6] last:border-b-0 py-[11px] px-[16px]">
          <span data-v-095dc081="" class="body2-bold-medium">알림</span>
          <div data-v-095dc081="">
            <router-link to="/TODO" data-v-095dc081="" class="flex flex-col">
              <span data-v-095dc081="" class="body3-regular-small MyPageSidebarDesktop__menu">
                알림
              </span>
            </router-link>
          </div>
        </div> -->
        <!---------------------선물함-------------------------->
        <div
          data-v-095dc081=""
          class="border-solid border-b border-[#efe8e6] last:border-b-0 py-[11px] px-[16px]"
        >
          <span data-v-095dc081="" class="body2-bold-medium">선물함</span>
          <div data-v-095dc081="">
            <router-link
              to="/gift/receive/list"
              data-v-095dc081=""
              class="flex flex-col"
            >
              <span
                data-v-095dc081=""
                href="https://www.idus.com/v2/mypage/gift/receive"
                class="body3-regular-small MyPageSidebarDesktop__menu"
              >
                받은 선물함
              </span>
            </router-link>
            <router-link
              to="/gift/give/list"
              data-v-095dc081=""
              class="flex flex-col"
            >
              <span
                data-v-095dc081=""
                href="https://www.idus.com/v2/mypage/gift/send"
                class="body3-regular-small MyPageSidebarDesktop__menu"
              >
                보낸 선물함
              </span>
            </router-link>
          </div>
        </div>
        <!---------------------나의 구매후기-------------------------->
        <div
          data-v-095dc081=""
          class="border-solid border-b border-[#efe8e6] last:border-b-0 py-[11px] px-[16px]"
        >
          <span data-v-095dc081="" class="body2-bold-medium"
            >나의 구매후기</span
          >
          <div
            data-v-095dc081=""
            v-for="item in ReviewItems"
            :key="item.id"
            :class="[{ 'bg-active': activeTab === item.path }]"
          >
            <div data-v-095dc081="">
              <router-link
                :to="item.path"
                @click="setActiveTab(item.id)"
                class="flex flex-col"
              >
                <span
                  data-v-095dc081=""
                  class="body3-regular-small MyPageSidebarDesktop__menu"
                >
                  {{ item.subLabel }}
                </span>
              </router-link>
            </div>
          </div>
        </div>
        <!---------------------관심-------------------------->
        <div
          data-v-095dc081=""
          class="border-solid border-b border-[#efe8e6] last:border-b-0 py-[11px] px-[16px]"
        >
          <span data-v-095dc081="" class="body2-bold-medium">관심</span>
          <div
            data-v-095dc081=""
            v-for="item in menuItems"
            :key="item.id"
            :class="[{ 'bg-active': activeTab === item.path }]"
          >
            <div data-v-095dc081="">
              <router-link
                :to="item.path"
                @click="setActiveTab(item.id)"
                class="flex flex-col"
              >
                <span
                  data-v-095dc081=""
                  class="body3-regular-small MyPageSidebarDesktop__menu"
                >
                  {{ item.subLabel }}
                </span>
              </router-link>
            </div>
          </div>
        </div>
        <!---------------------할인혜택-------------------------->
        <div
          data-v-095dc081=""
          class="border-solid border-b border-[#efe8e6] last:border-b-0 py-[11px] px-[16px]"
        >
          <span data-v-095dc081="" class="body2-bold-medium">할인혜택</span>
          <div data-v-095dc081="">
            <router-link to="/myCouponList" class="flex flex-col">
              <span
                data-v-095dc081=""
                class="body3-regular-small MyPageSidebarDesktop__menu"
              >
                쿠폰함
              </span>
            </router-link>
            <!--            <router-link to="/TODO" data-v-095dc081="" class="flex flex-col">-->
            <!--              <span-->
            <!--                data-v-095dc081=""-->
            <!--                class="body3-regular-small MyPageSidebarDesktop__menu"-->
            <!--              >-->
            <!--                적립금-->
            <!--              </span>-->
            <!--            </router-link>-->
          </div>
        </div>
        <!---------------------내 정보-------------------------->
        <div
          data-v-095dc081=""
          class="border-solid border-b border-[#efe8e6] last:border-b-0 py-[11px] px-[16px]"
        >
          <span data-v-095dc081="" class="body2-bold-medium">내 정보</span>
          <div data-v-095dc081="">
            <router-link to="/grade" data-v-095dc081="" class="flex flex-col">
              <span
                data-v-095dc081=""
                href=""
                class="body3-regular-small MyPageSidebarDesktop__menu"
              >
                회원 등급
              </span>
            </router-link>
            <router-link
              to="/update/member-info"
              data-v-095dc081=""
              class="flex flex-col"
            >
              <span
                data-v-095dc081=""
                href="https://www.idus.com/v2/mypage/edit-user-info"
                class="router-link-active router-link-exact-active body3-regular-small MyPageSidebarDesktop__menu"
                aria-current="page"
              >
                회원 정보 관리
              </span>
            </router-link>
            <router-link
              to="/deliveryAddress"
              data-v-095dc081=""
              class="flex flex-col"
            >
              <span
                data-v-095dc081=""
                class="router-link-active router-link-exact-active body3-regular-small MyPageSidebarDesktop__menu"
                aria-current="page"
              >
                배송지 관리
              </span>
            </router-link>
          </div>
        </div>
      </nav>
    </div>
  </div>
</template>

<script>
import { defineComponent } from "vue";
import { useMemberStore } from "@/stores/useMemberStore";
import { useSideBarStore } from "@/stores/useSidebarStore";
import { mapStores } from "pinia";

export default defineComponent({
  name: "MyPageSideBarComponent",
  computed: {
    ...mapStores(useMemberStore),
    ...mapStores(useSideBarStore),
  },
  //setup() : 반응형 상태(reactive, ref)정의, 컴포넌트의 데이터 상태관리
  // 값이 변경될 때마다 자동으로 UI를 업데이트.
  setup() {
    const sideBarStore = useSideBarStore();

    const setActiveTab = (tab) => {
      sideBarStore.setActiveTab(tab);
    };

    return {
      sideBarStore,
      setActiveTab,
      activeTab: sideBarStore.activeTab,
      menuItems: [
        {
          id: 0,
          label: "관심",
          path: "/mypage/favorite/likes",
          subLabel: "찜한 작품",
        },
        {
          id: 1,
          label: "관심",
          path: "/mypage/favorite/follow-artist",
          subLabel: "팔로우하는 작가",
        },
        //최근본상품X
        // {
        //   id: 2,
        //   label: "관심",
        //   path: "/mypage/favorite/recent-view",
        //   subLabel: "최근 본 작품",
        // },
      ],
      ReviewItems: [
        {
          id: 0,
          label: "리뷰",
          path: "/review/writable",
          subLabel: "작성 가능 후기",
        },
        {
          id: 1,
          label: "리뷰",
          path: "/review/written",
          subLabel: "작성한 후기",
        },
      ],
    };
  },
});
</script>

<style>
.profile-area {
  padding: 25px 0 28px;
  width: 100%;
  border: 1px solid black;
}
</style>
