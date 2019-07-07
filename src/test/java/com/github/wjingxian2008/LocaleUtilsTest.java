package com.github.wjingxian2008;

import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;


public class LocaleUtilsTest {

    private LocaleUtils localeUtils;
    private static final String EMPTY = "";

    @Before
    public void setup() {
        localeUtils = new LocaleUtils();
    }

    @Test
    public void should_return_null_when_input_is_null() {
        // given
        // when
        //then
        assertThat(localeUtils.toLocale(null)).isEqualTo(null);
    }

    @Test
    public void should_return_empty_when_input_is_empty() {
        // given
        // when
        // then
        assertThat(localeUtils.toLocale(EMPTY)).isEqualTo(new Locale(EMPTY, EMPTY));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_args_exception_when_input_contains() {
        // given
        // when
        localeUtils.toLocale("88#99");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_args_exception_when_input_length_less_than_two() {
        // given
        // when
        localeUtils.toLocale("8");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_args_exception_when_input_length_less_than_three() {
        // given
        // when
        localeUtils.toLocale("_8");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_args_exception_when_input_senond_char_not_uppercase() {
        // given
        // when
        localeUtils.toLocale("_Ab");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_args_exception_when_input_third_char_not_uppercase() {
        // given
        // when
        localeUtils.toLocale("_aB");
        // then
    }

    @Test
    public void should_return_locale_when_input_is_right_start_with_underline() {
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("_CH")).isEqualTo(new Locale(EMPTY, "CH"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_args_exception_when_input_length_is_four() {
        // given
        // when
        localeUtils.toLocale("_BB_");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_args_exception_when_input_forth_is_not_underline() {
        // given
        // when
        localeUtils.toLocale("_BBBB");
        // then
    }

    @Test
    public void should_return_locale_when_input_country_and_variant() {
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("_CN_CHN")).isEqualTo(new Locale(EMPTY, "CN", "CHN"));
    }

    @Test
    public void should_return_locale_when_input_is_ISO0639_and_length_is_two() {
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("ab")).isEqualTo(new Locale("ab"));
    }

    @Test
    public void should_return_locale_when_input_is_ISO0639_and_length_is_three() {
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("abc")).isEqualTo(new Locale("abc"));
    }

    @Test
    public void should_return_locale_when_input_is_ISO_country_and_language(){
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("cn_CN")).isEqualTo(new Locale("cn","CN"));
    }

    @Test
    public void should_return_locale_when_input_is_numeric_country_and_language(){
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("cn_123")).isEqualTo(new Locale("cn","123"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_args_exception_when_with_invalid_country_code() {
        // given
        // when
        localeUtils.toLocale("cn_abc");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_args_exception_when_with_empty_country_code() {
        // given
        // when
        localeUtils.toLocale("cn_");
        // then
    }


    @Test
    public void should_return_locale_when_input_with_language_country_variant(){
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("cn_123_ab")).isEqualTo(new Locale("cn","123","ab"));
    }

    @Test
    public void should_return_locale_when_input_with_language_uppercace_country_variant(){
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("cn_AB_ab")).isEqualTo(new Locale("cn","AB","ab"));
    }


    @Test
    public void should_return_locale_when_input_with_language_variant(){
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("cn__ab")).isEqualTo(new Locale("cn","","ab"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_args_exception_when_with_invalid_variant_code() {
        // given
        // when
        localeUtils.toLocale("ab_AB_");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_args_exception_when_with_invalid_language_code_three() {
        // given
        // when
        localeUtils.toLocale("AB_abc_a");
        // then
    }


    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_args_exception_when_with_invalid_country_code_three() {
        // given
        // when
        localeUtils.toLocale("ab_abc_ab");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_args_exception_when_with_invalid_language_code() {
        // given
        // when
        localeUtils.toLocale("AB_abc");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_args_exception_when_with_invalid_input() {
        // given
        // when
        localeUtils.toLocale("AB_abc_ab_78");
        // then
    }

}