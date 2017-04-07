package com.twtstudio.one.Bean

/**
 * Created by retrox on 06/04/2017.
 */


class Bean {


    /**
     * res : 0
     * data : {"hpcontent_id":"1616","hp_title":"VOL.1589","author_id":"-1","hp_img_url":"http://image.wufazhuce.com/Fols12YuADCnC3P3KRmJyUTWgxKd","hp_img_original_url":"http://image.wufazhuce.com/Fols12YuADCnC3P3KRmJyUTWgxKd","hp_author":"绘画＆austin_sandwich 作品","ipad_url":"http://image.wufazhuce.com/Fols12YuADCnC3P3KRmJyUTWgxKd","hp_content":"爱源自好奇和期待。你给了对方感到舒服的一切，满足了对方的所有期待，成全了对方的全部好奇，对方怎么对你忐忑心跳，为你显露出的一点好意而惊喜欢欣，对你意犹未尽？可是我如果爱啊，总喜欢付出。性情再酷，也愿意在爱中黏糊糊。 by 大斯","hp_makettime":"2017-02-11 06:00:00","hide_flag":"0","last_update_date":"2017-02-08 12:58:00","web_url":"http://m.wufazhuce.com/one/1616","wb_img_url":"","image_authors":"austin_sandwich","text_authors":"大斯","image_from":"","text_from":"","content_bgcolor":"#FFFFFF","template_category":"0","maketime":"2017-02-11 06:00:00","share_list":{"wx":{"title":"","desc":"","link":"","imgUrl":""},"weibo":{"title":"ONE·一个 爱源自好奇和期待。你给了对方感到舒服的一切，满足了对方的所有期待，成全了对方的全部好奇，对方怎么对你忐忑心跳，为你显露出的一点好意而惊喜欢欣，对你意犹未尽？可是我如果爱啊，总喜欢付出。性情再酷\u2026\u2014\u2014大斯 下载ONE·一个APP:http://weibo.com/p/100404157874","desc":"","link":"","imgUrl":""},"qq":{"title":"","desc":"","link":"","imgUrl":""}},"praisenum":19889,"sharenum":4126,"commentnum":0}
     */

    var res: Int = 0
    var data: DataBean? = null

    class DataBean {
        /**
         * hpcontent_id : 1616
         * hp_title : VOL.1589
         * author_id : -1
         * hp_img_url : http://image.wufazhuce.com/Fols12YuADCnC3P3KRmJyUTWgxKd
         * hp_img_original_url : http://image.wufazhuce.com/Fols12YuADCnC3P3KRmJyUTWgxKd
         * hp_author : 绘画＆austin_sandwich 作品
         * ipad_url : http://image.wufazhuce.com/Fols12YuADCnC3P3KRmJyUTWgxKd
         * hp_content : 爱源自好奇和期待。你给了对方感到舒服的一切，满足了对方的所有期待，成全了对方的全部好奇，对方怎么对你忐忑心跳，为你显露出的一点好意而惊喜欢欣，对你意犹未尽？可是我如果爱啊，总喜欢付出。性情再酷，也愿意在爱中黏糊糊。 by 大斯
         * hp_makettime : 2017-02-11 06:00:00
         * hide_flag : 0
         * last_update_date : 2017-02-08 12:58:00
         * web_url : http://m.wufazhuce.com/one/1616
         * wb_img_url :
         * image_authors : austin_sandwich
         * text_authors : 大斯
         * image_from :
         * text_from :
         * content_bgcolor : #FFFFFF
         * template_category : 0
         * maketime : 2017-02-11 06:00:00
         * share_list : {"wx":{"title":"","desc":"","link":"","imgUrl":""},"weibo":{"title":"ONE·一个 爱源自好奇和期待。你给了对方感到舒服的一切，满足了对方的所有期待，成全了对方的全部好奇，对方怎么对你忐忑心跳，为你显露出的一点好意而惊喜欢欣，对你意犹未尽？可是我如果爱啊，总喜欢付出。性情再酷\u2026\u2014\u2014大斯 下载ONE·一个APP:http://weibo.com/p/100404157874","desc":"","link":"","imgUrl":""},"qq":{"title":"","desc":"","link":"","imgUrl":""}}
         * praisenum : 19889
         * sharenum : 4126
         * commentnum : 0
         */

        var hpcontent_id: String? = null
        var hp_title: String? = null
        var author_id: String? = null
        var hp_img_url: String? = null
        var hp_img_original_url: String? = null
        var hp_author: String? = null
        var ipad_url: String? = null
        var hp_content: String? = null
        var hp_makettime: String? = null
        var hide_flag: String? = null
        var last_update_date: String? = null
        var web_url: String? = null
        var wb_img_url: String? = null
        var image_authors: String? = null
        var text_authors: String? = null
        var image_from: String? = null
        var text_from: String? = null
        var content_bgcolor: String? = null
        var template_category: String? = null
        var maketime: String? = null
        var share_list: ShareListBean? = null
        var praisenum: Int = 0
        var sharenum: Int = 0
        var commentnum: Int = 0

        class ShareListBean {
            /**
             * wx : {"title":"","desc":"","link":"","imgUrl":""}
             * weibo : {"title":"ONE·一个 爱源自好奇和期待。你给了对方感到舒服的一切，满足了对方的所有期待，成全了对方的全部好奇，对方怎么对你忐忑心跳，为你显露出的一点好意而惊喜欢欣，对你意犹未尽？可是我如果爱啊，总喜欢付出。性情再酷\u2026\u2014\u2014大斯 下载ONE·一个APP:http://weibo.com/p/100404157874","desc":"","link":"","imgUrl":""}
             * qq : {"title":"","desc":"","link":"","imgUrl":""}
             */

            var wx: WxBean? = null
            var weibo: WeiboBean? = null
            var qq: QqBean? = null

            class WxBean {
                /**
                 * title :
                 * desc :
                 * link :
                 * imgUrl :
                 */

                var title: String? = null
                var desc: String? = null
                var link: String? = null
                var imgUrl: String? = null
            }

            class WeiboBean {
                /**
                 * title : ONE·一个 爱源自好奇和期待。你给了对方感到舒服的一切，满足了对方的所有期待，成全了对方的全部好奇，对方怎么对你忐忑心跳，为你显露出的一点好意而惊喜欢欣，对你意犹未尽？可是我如果爱啊，总喜欢付出。性情再酷…——大斯 下载ONE·一个APP:http://weibo.com/p/100404157874
                 * desc :
                 * link :
                 * imgUrl :
                 */

                var title: String? = null
                var desc: String? = null
                var link: String? = null
                var imgUrl: String? = null
            }

            class QqBean {
                /**
                 * title :
                 * desc :
                 * link :
                 * imgUrl :
                 */

                var title: String? = null
                var desc: String? = null
                var link: String? = null
                var imgUrl: String? = null
            }
        }
    }
}
