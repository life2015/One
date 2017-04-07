package com.twtstudio.one.Bean

/**
 * Created by jcy on 2016/5/14.
 */
class BeanListMonth {


    var res: Int = 0
    /**
     * hpcontent_id : 1337
     * hp_title : VOL.1315
     * author_id : -1
     * hp_img_url : http://image.wufazhuce.com/Fjx5fvB_9LjdTP6e5zLC9Tl879o7
     * hp_img_original_url : http://image.wufazhuce.com/Fjx5fvB_9LjdTP6e5zLC9Tl879o7
     * hp_author : One Day& 狐狸狐狸鱼 作品
     * ipad_url : http://image.wufazhuce.com/Fkqf5fjDDbJZamYDcHCxPeBsIetk
     * hp_content : 在我们的一生中，遇到爱，遇到性都不稀罕，稀罕的是遇到了解。 by 廖一梅
     * hp_makettime : 2016-05-13 21:00:00
     * last_update_date : 2016-05-05 16:39:22
     * web_url : http://m.wufazhuce.com/one/1337
     * wb_img_url :
     * push_id : null
     * praisenum : 17756
     * sharenum : 2544
     * commentnum : 54
     */

    var data: List<DataBean>? = null

    class DataBean {
        var hpcontent_id: String? = null
        var hp_title: String? = null
        var author_id: String? = null
        var hp_img_url: String? = null
        var hp_img_original_url: String? = null
        var hp_author: String? = null
        var ipad_url: String? = null
        var hp_content: String? = null
        var hp_makettime: String? = null
        var last_update_date: String? = null
        var web_url: String? = null
        var wb_img_url: String? = null
        var push_id: Any? = null
        var praisenum: Int = 0
        var sharenum: Int = 0
        var commentnum: Int = 0
    }
}
